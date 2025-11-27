

public class Course{
    String name;
    String id;
    int credits;

    public Course( String name, String id, int credits ){
        this.name = name;
        this.id = id;
        this.credits = credits;
    }// constructor

    @Override
    public String toString()
    {
        return "Course{" + "name='" + name + '\'' + ", id='" + id + '\'' + ", credits=" + credits + '}';
    }
}

