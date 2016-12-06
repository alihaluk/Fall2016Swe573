package tr.edu.boun.healthtracker.model;

import java.util.List;

import tr.edu.boun.healthtracker.model.inner.ListItemObject;

/**
 * Created by haluks on 06/12/2016.
 */

public class ListJsonModel
{
    /*
        {"list": {
            "sort": "n",
            "end": 50,
             "item": [{"id": "749", "name": "(+)-Catechin", "offset": 0}, {"id": "794", "name": "(+)-Gallocatechin", "offset": 1}],
             "sr": "28",
             "start": 0,
             "lt": "n",
             "total": 190
             }}
     */

    private ListObject list;

    public ListObject getList()
    {
        return list;
    }

    public class ListObject
    {
        String sort; // sort order: n=name or id (Meaning of id varies by list type: nutrient number for a nutrient list, NDBno for a foods list ,food group id for a food group list
        Integer end;
        List<ListItemObject> item;
        String sr;
        Integer start;
        String lt; // 	list type(lt): f = food , n = all nutrients, ns = speciality nutrients, nr = standard release nutrients only,g = food group
        Integer total;

        public Integer getEnd()
        {
            return end;
        }

        public List<ListItemObject> getItem()
        {
            return item;
        }

        public String getLt()
        {
            return lt;
        }

        public String getSort()
        {
            return sort;
        }

        public String getSr()
        {
            return sr;
        }

        public Integer getStart()
        {
            return start;
        }

        public Integer getTotal()
        {
            return total;
        }
    }
}
