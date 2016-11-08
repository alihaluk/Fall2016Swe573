# from api.py
from pycnic.core import WSGI, Handler
import json
import requests

api_key = "DEMO_KEY"

class Hello(Handler):
    def get(self):
        return {
            "Health Tracker API v0.1"
        }

class List(Handler):
    def get(self, lt="f", max=50, offset=0, sort="n"):

        if (self.request.args.get("lt")):
            lt = self.request.args.get("lt")
        
        if (self.request.args.get("max")):
            max = self.request.args.get("max")

        if (self.request.args.get("offset")):
            offset = self.request.args.get("offset")

        if (self.request.args.get("sort")):
            sort = self.request.args.get("sort")

        url = "http://api.nal.usda.gov/ndb/list?" + "format=JSON" + "&lt=" + lt + "&max=" + str(max) + "&offset=" + str(offset) + "&sort=" + sort + "&api_key=" + api_key

        response = requests.get(url)

        if response.ok:
            jData = json.loads(response.content)
            return json.dumps(jData, indent=4)
        else:
            return {
                "error": response.status
            }

class FoodReport(Handler):
    def get(self, ndbno="", type="b"):

        if (self.request.args.get("ndbno")):
            ndbno = self.request.args.get("ndbno")
        else:
            return { "error" : "ndbno can not be null" }

        if (self.request.args.get("type")):
            type = self.request.args.get("type")

        url = "http://api.nal.usda.gov/ndb/reports/?ndbno=" + ndbno + "&type=" + type + "&format=JSON&api_key=" + api_key

        response = requests.get(url)

        if response.ok:
            jData = json.loads(response.content)
            return json.dumps(jData, indent=4)
        else:
            return {
                "error" : response.status
            }

class NutrientReport(Handler):
    def get(self, fg="", max=50, offset=0, ndbno="", nutrients="{}", sort="f", subset=0):

        if (self.request.args.get("nutrients")):
            nutrients = self.request.args.get("nutrients")
        else:
            return { "error" : "nutrients can not be null" }

        if (self.request.args.get("fg")):
            fg = self.request.args.get("fg")

        if (self.request.args.get("max")):
            max = self.request.args.get("max")

        if (self.request.args.get("offset")):
            offset = self.request.args.get("offset")

        if (self.request.args.get("ndbno")):
            ndbno = self.request.args.get("ndbno")

        if (self.request.args.get("sort")):
            sort = self.request.args.get("sort")

        if (self.request.args.get("subset")):
            subset = self.request.args.get("subset")

        # url
        nut_arr = json.loads(nutrients)
        
        nutr_part = ""
        for i in range(len(nut_arr)):
            nutr_part += ("&nutrients=" + str(nut_arr[i]))

        url = "http://api.nal.usda.gov/ndb/nutrients/?format=json&api_key=" + api_key + nutr_part

        if (len(ndbno) > 0):
            url += ("&ndbno=" + ndbno)
        elif (len(fg) > 0):
            fg_arr = json.loads(fg)

            fg_part = ""
            for i in range(len(fg_arr)):
                fg_part += ("&fg=" + str(fg_arr[i]))

            url += fg_part

        response = requests.get(url)

        if response.ok:
            jData = json.loads(response.content)
            return json.dumps(jData, indent=4)
        else:
            return {
                "error" : response.status
            }

class app(WSGI):
    routes = [
        ("/", Hello()),
        ("/list", List()),
        ("/foodreport", FoodReport()),
        ("/nutrientreport", NutrientReport())
    ]
