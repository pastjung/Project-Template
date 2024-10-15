from fastapi import FastAPI

from core.docs import *

def get_server():
    server = FastAPI(
        title='Project Template', 
        docs_url="/docs", redoc_url=None,
        version="1.0.0",
        description=root_description,
        openapi_url="/openapi.json"
    )

    return server

app = get_server()

@app.get('/api/ping', tags=['Root'])
def ping():
    return 200