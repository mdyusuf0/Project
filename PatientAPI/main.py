from fastapi import FastAPI, Request
from fastapi.templating import Jinja2Templates
from fastapi.responses import HTMLResponse
import json
from pymongo import MongoClient
import os

app = FastAPI()

template = Jinja2Templates(directory="template")

def load_data():
    with open("patients.json", "r") as f:
        return json.load(f)


from typing import Optional

@app.get("/search")
def search_patient(name: Optional[str] = None, age: Optional[int] = None):
    patients = load_data()
    # Filter patients based on name and age if provided
    result = patients
    if name:
        result = [p for p in result if name.lower() in p["name"].lower()]
    if age:
        result = [p for p in result if p.get("age") == age]
    if result:
        return result
    return {"message": "No matching data found"}



@app.get("/", response_class=HTMLResponse)
def hello(request: Request):
    return template.TemplateResponse("view.html", {"request": request, "patients": load_data()})


@app.get("/view", response_class=HTMLResponse)
def view(request: Request):
    return template.TemplateResponse("view.html", {"request": request, "patients": load_data()})
