from pymongo import MongoClient
import os

# MongoDB : 환경 변수 불러오기
db_ip_address = os.getenv('MONGODB_IP_ADDRESS')
db_port = os.getenv('MONGODB_SERVER_PORT')
db_name = os.getenv('MONGODB_DB_NAME')
collection_name = os.getenv('MONGODB_COLLECTION_NAME')
username = os.getenv('MONGODB_ID')  # 사용자 이름
password = os.getenv('MONGODB_ROOT_PASSWORD')  # 비밀번호

client = MongoClient(f'mongodb://{username}:{password}@{db_ip_address}:{db_port}/')
mongodb = client[db_name]
collection = mongodb[collection_name]