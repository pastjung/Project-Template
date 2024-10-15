from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
from starlette.config import Config

# 환경 변수 불러오기
config = Config('.env')

id = config('RDBMS_ID')
password = config('RDBMS_ROOT_PASSWORD')
db_ip = config('RDBMS_IP_ADDRESS')
db_port = config('RDBMS_SERVER_PORT')
db_name = config('RDBMS_DATABASE')

# DB 연결 설정
DB_URL=f'mysql+pymysql://{id}:{password}@{db_ip}:{db_port}/{db_name}'

# 엔진 생성
engine = create_engine(DB_URL, echo=True)   # echo=True : 실행되는 SQL 쿼리 확인

# 세션 생성
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

# 베이스 클래스 생성
Base = declarative_base()

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()