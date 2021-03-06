package tr.edu.boun.healthtracker.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by haluks on 15/12/2016.
 */

public class DBOpenHelper extends SQLiteOpenHelper
{
    public DBOpenHelper(Context context) {
        super(context, DB.DATABASE_NAME, null, DB.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DB.TABLE_CREATE_EXERCISE_CAL_BURNED);
        db.execSQL(DB.TABLE_CREATE_USER);

        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cycling, mountain bike, bmx',8.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cycling, <10 mph, leisure bicycling',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cycling, >20 mph, racing',15.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cycling, 10-11.9 mph, light',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cycling, 12-13.9 mph, moderate',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cycling, 14-15.9 mph, vigorous',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cycling, 16-19 mph, very fast, racing',11.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Unicycling',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Stationary cycling, very light',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Stationary cycling, light',5.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Stationary cycling, moderate',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Stationary cycling, vigorous',10.49)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Stationary cycling, very vigorous',12.49)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Calisthenics, vigorous, pushups, situps…',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Calisthenics, light',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Circuit training, minimal rest',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Weight lifting, body building, vigorous',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Weight lifting, light workout',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Health club exercise',5.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Stair machine',8.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Rowing machine, light',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Rowing machine, moderate',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Rowing machine, vigorous',8.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Rowing machine, very vigorous',11.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Ski machine',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Aerobics, low impact',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Aerobics, high impact',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Aerobics, step aerobics',8.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Aerobics, general',6.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Jazzercise',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Stretching, hatha yoga',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Mild stretching',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Instructing aerobic class',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Water aerobics',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Ballet, twist, jazz, tap',4.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Ballroom dancing, slow',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Ballroom dancing, fast',5.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, 5 mph (12 minute mile)',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, 5.2 mph (11.5 minute mile)',8.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, 6 mph (10 min mile)',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, 6.7 mph (9 min mile)',10.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, 7 mph (8.5 min mile)',11.49)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, 7.5mph (8 min mile)',12.49)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, 8 mph (7.5 min mile)',13.49)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, 8.6 mph (7 min mile)',13.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, 9 mph (6.5 min mile)',14.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, 10 mph (6 min mile)',15.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, 10.9 mph (5.5 min mile)',17.98)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, cross country',8.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, general',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, on a track, team practice',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, stairs, up',14.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Track and field (shot, discus)',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Track and field (high jump, pole vault)',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Track and field (hurdles)',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Archery',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Badminton',4.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Basketball game, competitive',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Playing basketball, non game',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Basketball, officiating',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Basketball, shooting baskets',4.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Basketball, wheelchair',6.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Running, training, pushing wheelchair',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Billiards',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Bowling',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Boxing, in ring',11.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Boxing, punching bag',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Boxing, sparring',8.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Coaching: football, basketball, soccer…',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cricket (batting, bowling)',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Croquet',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Curling',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Darts (wall or lawn)',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Fencing',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Football, competitive',8.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Football, touch, flag, general',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Football or baseball, playing catch',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Frisbee playing, general',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Frisbee, ultimate frisbee',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Golf, general',4.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Golf, walking and carrying clubs',4.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Golf, driving range',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Golf, miniature golf',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Golf, walking and pulling clubs',4.3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Golf, using power cart',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Gymnastics',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Hacky sack',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Handball',11.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Handball, team',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Hockey, field hockey',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Hockey, ice hockey',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Riding a horse, general',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Horesback riding, saddling horse',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Horseback riding, grooming horse',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Horseback riding, trotting',6.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Horseback riding, walking',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Horse racing, galloping',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Horse grooming, moderate',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Horseshoe pitching',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Jai alai',11.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Martial arts, judo, karate, jujitsu',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Martial arts, kick boxing',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Martial arts, tae kwan do',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Krav maga training',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Juggling',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Kickball',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Lacrosse',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Orienteering',8.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Playing paddleball',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Paddleball, competitive',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Polo',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Racquetball, competitive',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Playing racquetball',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Rock climbing, ascending rock',10.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Rock climbing, rappelling',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Jumping rope, fast',11.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Jumping rope, moderate',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Jumping rope, slow',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Rugby',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Shuffleboard, lawn bowling',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Skateboarding',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Roller skating',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Roller blading, in-line skating',11.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Sky diving',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Soccer, competitive',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Playing soccer',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Softball or baseball',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Softball, officiating',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Softball, pitching',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Squash',11.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Table tennis, ping pong',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Tai chi',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Playing tennis',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Tennis, doubles',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Tennis, singles',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Trampoline',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Volleyball, competitive',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Playing volleyball',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Volleyball, beach',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Wrestling',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Wallyball',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Backpacking, Hiking with pack',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Carrying infant, level ground',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Carrying infant, upstairs',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Carrying 16 to 24 lbs, upstairs',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Carrying 25 to 49 lbs, upstairs',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Standing, playing with children, light',2.8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walk/run, playing with children, moderate',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walk/run, playing with children, vigorous',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Carrying small children',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Loading, unloading car',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Climbing hills, carrying up to 9 lbs',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Climbing hills, carrying 10 to 20 lb',7.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Climbing hills, carrying 21 to 42 lb',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Climbing hills, carrying over 42 lb',8.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking downstairs',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Hiking, cross country',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Bird watching',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Marching, rapidly, military',6.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Children''s games, hopscotch, dodgeball',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Pushing stroller or walking with children',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Pushing a wheelchair',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Race walking',6.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Rock climbing, mountain climbing',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking using crutches',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking the dog',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking, under 2.0 mph, very slow',2)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking 2.0 mph, slow',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking 2.5 mph',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking 3.0 mph, moderate',3.3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking 3.5 mph, brisk pace',3.8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking 3.5 mph, uphill',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking 4.0 mph, very brisk',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking 4.5 mph',6.3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking 5.0 mph',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Boating, power, speed boat',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Canoeing, camping trip',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Canoeing, rowing, light',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Canoeing, rowing, moderate',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Canoeing, rowing, vigorous',11.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Crew, sculling, rowing, competition',11.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Kayaking',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Paddle boat',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Windsurfing, sailing',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Sailing, competition',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Sailing, yachting, ocean sailing',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Skiing, water skiing',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Ski mobiling',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Skin diving, fast',15.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Skin diving, moderate',12.49)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Skin diving, scuba diving',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Snorkeling',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Surfing, body surfing or board surfing',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Whitewater rafting, kayaking, canoeing',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Swimming laps, freestyle, fast',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Swimming laps, freestyle, slow',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Swimming backstroke',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Swimming breaststroke',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Swimming butterfly',10.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Swimming leisurely, not laps',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Swimming sidestroke',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Swimming synchronized',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Swimming, treading water, fast, vigorous',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Swimming, treading water, moderate',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Water aerobics, water calisthenics',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Water polo',9.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Water volleyball',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Water jogging',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Diving, springboard or platform',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Ice skating, < 9 mph',5.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Ice skating, average speed',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Ice skating, rapidly',8.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Speed skating, ice, competitive',14.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cross country snow skiing, slow',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cross country skiing, moderate',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cross country skiing, vigorous',8.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cross country skiing, racing',13.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cross country skiing, uphill',16.49)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Snow skiing, downhill skiing, light',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Downhill snow skiing, moderate',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Downhill snow skiing, racing',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Sledding, tobagganing, luge',7)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Snow shoeing',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Snowmobiling',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('General housework',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cleaning gutters',5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Painting',4.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Sit, playing with animals',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walk / run, playing with animals',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Bathing dog',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Mowing lawn, walk, power mower',5.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Mowing lawn, riding mower',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking, snow blower',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Riding, snow blower',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Shoveling snow by hand',5.99)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Raking lawn',4.3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Gardening, general',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Bagging grass, leaves',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Watering lawn or garden',1.51)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Weeding, cultivating garden',4.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Carpentry, general',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Carrying heavy loads',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Carrying moderate loads upstairs',8)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('General cleaning',3.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Cleaning, dusting',2.5)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Taking out trash',3)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Walking, pushing a wheelchair',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Teach physical education,exercise class',4)");
        db.execSQL("INSERT INTO tblExerciseCalBurned (Name, CalValuePerKG) VALUES ('Teach exercise classes (& participate)',6.5)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
