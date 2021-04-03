#include "object.h"
#include <iostream>

using namespace std;

MyObject::MyObject(){}

MyObject::MyObject(int id, string label, string type){
    this->id = id;
    this->label = label;
    this->type = type;
}

void MyObject::setId(int id){
    this->id = id;
}

void MyObject::setLabel(string label){
    this->label = label;
}

void MyObject::setType(string type){
    this->type = type;
}

int MyObject::getId(){
    return this->id;
}

string MyObject::getLabel(){
    return this->label;
}

string MyObject::getType(){
    return this->type;
}

void MyObject::myObjectDetails(){
    cout << "Object infos:\n ID: " << this->getId() << "Label: " << this->getLabel() << "Type: " << this->getType();
}
