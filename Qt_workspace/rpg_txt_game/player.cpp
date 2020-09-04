#include "player.h"

Player::Player(){
    Creature();
}
Player::Player(string name, string description, int hitPoints,
               int damage, int healAmount)
{
    Creature(name, description, hitPoints, damage);
    this->healAmount = healAmount;
}

void Player::heal(){
    this->setHitPoints(this->healAmount);
    cout << this->getName() << "is healed by " << this->healAmount << endl;
}

