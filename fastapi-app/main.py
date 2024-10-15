from fastapi import FastAPI

app = FastAPI()

@app.get('/api/ping', tags=['Root'])
def ping():
    return 200