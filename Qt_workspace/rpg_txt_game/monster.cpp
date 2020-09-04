#include "monster.h"

Monster::Monster(){
    Creature();
    this->enrageThreshold = 0;
}
Monster::Monster(string name, string description, int hitPoints, int damage,
                 int enrageThrehold)
{
    Creature(name, description, hitPoints, damage);
    this->enrageThreshold = enrageThrehold;
}

void Monster::enrage(){
    this->isEnraged = this->canEnrage();
    if(this->isEnraged){
        this->setDamage(this->getDamage()*2);
        cout << this->getName() << " has enraged"<<endl;
    }
}

bool Monster::canEnrage(){
    return Monster::getHitPoint() < this->enrageThreshold ? true : false;
}
