#include "Point3D.h"
#include <iostream>

using namespace std;

Point3D::Point3D(double nb1, double nb2, double nb3)
{
    this->x = nb1;
    this->y = nb2;
    this->z = nb3;
}

Point3D::Point3D(double nb)
{
    this->x = nb;
    this->y = nb;
    this->z = nb;
}

Point3D& Point3D::operator = (const Point3D& other)
{
	if (this == &other)
		return *this;
	this->x = other.x;
	this->y = other.y;
	this->z = other.z;
	return *this;
}

Point3D& Point3D::operator + (const Point3D& other)
{
	return *(new Point3D(this->x + other.x, this->y + other.y, this->z + other.z));
}

Point3D& Point3D::operator - (const Point3D& other)
{
	return *(new Point3D(this->x - other.x, this->y - other.y, this->z - other.z));
}

Point3D& Point3D::operator * (const Point3D& other)
{
	return *(new Point3D(this->x * other.x, this->y * other.y, this->z * other.z));
}

ostream& operator << (ostream& sortie, const Point3D& p)
{
    sortie << "(" << p.x << ", " << p.y << ", " << p.z << ")" ;
    return sortie ;
}
