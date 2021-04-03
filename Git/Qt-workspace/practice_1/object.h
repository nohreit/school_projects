#ifndef OBJECT_H
#define OBJECT_H

#include <string>

using namespace std;

class MyObject
{
private:
    int id;
    string label;
    string type;

public:
    MyObject();
    MyObject(int, string, string);

    void setId(int);
    void setLabel(string);
    void setType(string);

    int getId();
    string getLabel();
    string getType();
    void myObjectDetails();
};

#endif // OBJECT_H
