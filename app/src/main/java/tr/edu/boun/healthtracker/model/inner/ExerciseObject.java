package tr.edu.boun.healthtracker.model.inner;

/**
 * Created by haluks on 15/12/2016.
 */

public class ExerciseObject
{
    String Name;
    Double Calorie;

    public Double getCalorie()
    {
        return Calorie;
    }

    public void setCalorie(Double calorie)
    {
        Calorie = calorie;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }
}
