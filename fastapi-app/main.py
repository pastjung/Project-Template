from fastapi import FastAPI, HTTPException
from sqlalchemy import text

from core.docs import *
from starlette.middleware.cors import CORSMiddleware
from fastapi.middleware.gzip import GZipMiddleware
from core.rdbms import Base, engine
from core.mongoDB import mongodb
from router import user_router, jwt_router

def get_server():
    server = FastAPI(
        title='Project Template', 
        docs_url="/docs", redoc_url=None,
        version="1.0.0",
        description=root_description,
        openapi_url="/openapi.json"
    )
    server.add_middleware(
        CORSMiddleware,
        allow_origins=['*'],
        allow_credentials=True,
        allow_methods=['*'],
        allow_headers=['*'],
    )
    server.add_middleware(
        GZipMiddleware, minimum_size=1000
    )

    return server

# 테이블 생성
Base.metadata.create_all(bind=engine)

app = get_server()

app.include_router(user_router.router, tags=['User'])
app.include_router(jwt_router.router, tags=['Jwt'])

@app.get('/api/ping', tags=['Root'])
def ping():
    return 200

@app.get("/api/rdbms/ping", tags=['Root'])
async def rdbms_ping():
    try:
        # 데이터베이스 연결 테스트
        with engine.connect() as connection:
            result = connection.execute(text("SELECT 1"))
            if result.scalar() == 1:
                return 200
            else:
                raise HTTPException(status_code=500, detail="Unexpected result from database")
    except Exception as e:
        # 연결 오류 발생 시
        raise HTTPException(status_code=500, detail=f"Database connection error: {str(e)}")

@app.get("/mongodb/ping", tags=['Root'])
async def mongodb_ping():
    try:
        # MongoDB에 ping 명령을 보내어 연결 확인
        mongodb.command("ping")
        return 200
    except ConnectionError:
        raise HTTPException(status_code=503, detail="Unable to connect to MongoDB")