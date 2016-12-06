package tr.edu.boun.healthtracker.model.inner;

import java.util.List;

/**
 * Created by haluks on 06/12/2016.
 */

public class FoodObject
{
    String ds;
    String name;
    String ndbno;
    List<NutrientObject> nutrients;

    public String getDs()
    {
        return ds;
    }

    public String getName()
    {
        return name;
    }

    public String getNdbno()
    {
        return ndbno;
    }

    public List<NutrientObject> getNutrients()
    {
        return nutrients;
    }
}
