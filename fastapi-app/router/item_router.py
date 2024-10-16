from fastapi import APIRouter
from model import item_model
from schema import item_schema
from service import item_service

router = APIRouter(
    prefix="/api/item/mongodb",
)

@router.post("/create", response_model=item_model.Item)
def create_item(item: item_schema.Item):
    return item_service.create_item(item)

@router.get("/reads", response_model=list[item_model.Item])
def read_items():
    return item_service.get_items()