package tr.edu.boun.healthtracker.model;

import java.util.List;

import tr.edu.boun.healthtracker.model.inner.SearchItemObject;

/**
 * Created by haluks on 06/12/2016.
 */

public class SearchModel
{
    /*
{
    "list": {
        "q": "white cheese",
        "sr": "28",
        "ds": "any",
        "start": 0,
        "end": 150,
        "total": 154,
        "group": "",
        "sort": "n",
        "item": [
     */

    public SearchObject list;

    public SearchObject getList()
    {
        return list;
    }

    public class SearchObject
    {
        String q;
        String sr;
        String ds;
        Integer start;
        Integer end;
        Integer total;
        String group;
        String sort;
        List<SearchItemObject> item;

        public String getDs()
        {
            return ds;
        }

        public Integer getEnd()
        {
            return end;
        }

        public String getGroup()
        {
            return group;
        }

        public List<SearchItemObject> getItem()
        {
            return item;
        }

        public String getQ()
        {
            return q;
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
