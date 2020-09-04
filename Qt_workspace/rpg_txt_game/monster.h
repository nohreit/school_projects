#ifndef MONSTER_H
#define MONSTER_H
#include <iostream>
#include "creature.h"

using namespace std;

class Monster: public Creature
{
private:
    bool isEnraged;
    int enrageThreshold;
public:
    Monster();
    Monster(string, string , int, int, int);
    void enrage();
    bool canEnrage();
};

#endif // MONSTER_H
