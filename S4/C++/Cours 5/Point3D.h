#include <iostream>

class Point3D
{
    public:
        Point3D(double nb1, double nb2, double nb3);
        Point3D(double nb);
        Point3D& operator = (const Point3D& other);
        Point3D& operator + (const Point3D& other);
        Point3D& operator - (const Point3D& other);
        Point3D& operator * (const Point3D& other);
        friend std::ostream& operator << (std::ostream&, const Point3D& other);
        friend std::istream& operator >> (std::istream&, Point3D& other);

    private:
        double x, y, z;
};
