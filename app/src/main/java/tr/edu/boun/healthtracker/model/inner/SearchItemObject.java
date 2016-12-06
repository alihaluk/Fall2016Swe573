package tr.edu.boun.healthtracker.model.inner;

/**
 * Created by haluks on 06/12/2016.
 */

public class SearchItemObject
{
    /*
                {
                "offset": 0,
                "group": "Branded Food Products Database",
                "name": "A MILD SEMI-SOFT WHITE CHEESE, UPC: 027568005803",
                "ndbno": "45032916",
                "ds": "BL"
            },
     */

    Integer offset;
    String group;
    String name;
    String ndbno;
    String ds;

    public String getDs()
    {
        return ds;
    }

    public String getGroup()
    {
        return group;
    }

    public String getName()
    {
        return name;
    }

    public String getNdbno()
    {
        return ndbno;
    }

    public Integer getOffset()
    {
        return offset;
    }
}
