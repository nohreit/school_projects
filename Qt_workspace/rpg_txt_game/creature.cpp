#include "creature.h"

Creature::Creature(){
    this->name = "";
    this->description = "";
    this->hitPoints = 0;
    this->damage = 0;
    this->room = Room();
}

Creature::Creature(string name, string description,
                   int hitPoints, int damage)
{
    this->name = name;
    this->description = description;
    this->hitPoints = hitPoints;
    this->damage = damage;
    this->room = Room();
}

void Creature::attack(Creature creature){
    cout << this->getName() << " attacks " + creature.getName() << ", dealing "
         << this->getDamage() << " damage(s)" <<endl;
}

void Creature::takeDamage(int damage){
    this->setDamage(this->getDamage()-damage);
}

bool Creature::isAlive(){
    return this->getHitPoint() > 0 ? true : false;
}

string Creature::toString(){
    return "name "+ this->getName() + "description"+this->getDescription() +
            "hitPoints" + to_string(this->getHitPoint()) + "damage "+ to_string(this->getDamage());
}

void Creature::setHitPoints(int hitPoints){
    this->hitPoints = hitPoints < 0 ? 0 : hitPoints;
}

string Creature::getName(){
    return this->name;
}

string Creature::getDescription(){
    return this->description;
}

int Creature::getHitPoint(){
    return this->hitPoints;
}

int Creature::getDamage(){
    return this->damage;
}

Room Creature::getRoom(){
    return this->room;
}
