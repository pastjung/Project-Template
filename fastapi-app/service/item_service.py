from repository import item_repository
from model.item_model import Item

def create_item(item: Item):
    return item_repository.create_item(item.dict())

def get_items():
    return item_repository.get_items()