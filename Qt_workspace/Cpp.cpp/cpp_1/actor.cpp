#include "actor.h"

Actor::Actor()
{

}

//getters
string Actor::get_label(){
    return this->label;
}

int Actor::get_hitPoint(){
    return this->hitPoint;
}
int Actor::get_manaPoint(){
    return this->manaPoint;
}
int Actor::get_staminaPoint(){
    return this->staminaPoint;
}
int Actor::get_atkPoint()
{
    return this->atkPoint;
}
int Actor::get_defPoint(){
    return this->defPoint;
}
int Actor::get_atkManaPoint(){
    return this->atkManaPoint;
}
int Actor::get_defManaPoint(){
    return this->defManaPoint;
}
//int Actor::get_actorClass(){}

//setters
void Actor::set_label(string label){
    this->label = label;
}
void Actor::set_hitPoint(int hp){
    this->hitPoint = hp;
}
void Actor::set_manaPoint(int mp){
    this->manaPoint = mp;
}
void Actor::set_staminaPoint(int sp){
    this->staminaPoint = sp;
}
void Actor::set_atkPoint(int ap){
    this->atkPoint = ap;
}
void Actor::set_defPoint(int dp){
    this->defPoint = dp;
}
void Actor::set_atkManaPoint(int amp){
    this->atkManaPoint = amp;
}
void Actor::set_defManaPoint(int dmp){
    this->defManaPoint = dmp;
}
//void Actor::set_actorClass(ActorClass actorClass){this-> = ;}

//actions

bool Actor::isAlive(int hp){
    if(hp == 0)
        return false;
    return true;
}
void Actor::checkHP(int hp){
    if(hp < 0)
        this->set_hitPoint(0);
}
void Actor::attack(Actor b){
    int dmg = 0;
    display(this->get_label()+" attaks "+ b.get_label());
    dmg = this->get_atkPoint()-b.defPoint; //damage calculation

    sleep_for(seconds(2));

    display(b.get_label()+" receives "+std::to_string(dmg));
    b.set_hitPoint(b.hitPoint-dmg); //deducte damages taken and set the new hp

    this->display(displayActor());
    b.display(displayActor());
}
void Actor::heal(Actor b){
    display(this->get_label()+" uses heal and regain +10 hp");
    b.set_hitPoint(b.get_hitPoint()+10);

    this->display(displayActor());
    b.display(displayActor());
}
void Actor::regenSP(Actor b){
    this->display(displayActor());
    b.display(displayActor());
}
void Actor::regenMP(Actor b){
    this->display(displayActor());
    b.display(displayActor());
}
bool Actor::isVictory(Actor b){
    if(this->get_hitPoint()== 0)
        return false;
    if(b)
}

//output

void Actor::display(string str){
    sleep_for(seconds(3));
    cout << str << endl;
}

string Actor::displayActor(){
    return this->get_label()+"\nHP : "+to_string(this->get_hitPoint())+"\nMP : "+
            to_string(this->get_manaPoint())+"\nSP : "+to_string(this->get_staminaPoint());
}
