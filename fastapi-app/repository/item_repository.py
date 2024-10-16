from core.mongoDB import collection
from model.item_model import Item

def create_item(item_data: Item):
    result = collection.insert_one(item_data)
    item_data['id'] = str(result.inserted_id)
    return item_data

def get_items():
    items = []
    for item in collection.find():
        item['id'] = str(item['_id'])   # MongoDB의 ObjectId를 문자열로 변환
        items.append(item)               # 변환된 item을 리스트에 추가
    return items
