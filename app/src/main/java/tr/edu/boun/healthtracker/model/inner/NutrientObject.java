package tr.edu.boun.healthtracker.model.inner;

import java.util.List;

/**
 * Created by haluks on 06/12/2016.
 */

public class NutrientObject
{
    String group;
    String name;
    String nutrient_id;
    String unit;
    String value;
    List<MeasureObject> measures;

    public String getGroup()
    {
        return group;
    }

    public List<MeasureObject> getMeasures()
    {
        return measures;
    }

    public String getName()
    {
        return name;
    }

    public String getNutrient_id()
    {
        return nutrient_id;
    }

    public String getUnit()
    {
        return unit;
    }

    public String getValue()
    {
        return value;
    }
}
