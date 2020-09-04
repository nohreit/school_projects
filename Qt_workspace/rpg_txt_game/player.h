#ifndef PLAYER_H
#define PLAYER_H
#include <iostream>
#include "creature.h"

using namespace std;

class Player: public Creature
{
private:
    int healAmount;
public:
    Player();
    Player(string, string, int, int, int);
    void heal();
};

#endif // PLAYER_H
