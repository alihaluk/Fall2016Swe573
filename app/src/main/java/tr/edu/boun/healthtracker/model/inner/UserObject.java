package tr.edu.boun.healthtracker.model.inner;

/**
 * Created by haluks on 21/12/2016.
 */

public class UserObject
{
    Integer Id;
    String Email;
    String Username;
    String Password;
    String Gender;
    Integer Age;
    Double Height;
    Double Weight;
    Double Bmi;
    Integer CalGoal;
    Boolean Active;

    public Boolean getActive()
    {
        return Active;
    }

    public void setActive(Boolean active)
    {
        Active = active;
    }

    public Integer getCalGoal()
    {
        return CalGoal;
    }

    public void setCalGoal(Integer calGoal)
    {
        CalGoal = calGoal;
    }

    public Double getBmi()
    {
        return Bmi;
    }

    public void setBmi(Double bmi)
    {
        Bmi = bmi;
    }

    public Integer getAge()
    {
        return Age;
    }

    public void setAge(Integer age)
    {
        Age = age;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String email)
    {
        Email = email;
    }

    public String getGender()
    {
        return Gender;
    }

    public void setGender(String gender)
    {
        Gender = gender;
    }

    public Double getHeight()
    {
        return Height;
    }

    public void setHeight(Double height)
    {
        Height = height;
    }

    public Integer getId()
    {
        return Id;
    }

    public void setId(Integer id)
    {
        Id = id;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String password)
    {
        Password = password;
    }

    public String getUsername()
    {
        return Username;
    }

    public void setUsername(String username)
    {
        Username = username;
    }

    public Double getWeight()
    {
        return Weight;
    }

    public void setWeight(Double weight)
    {
        Weight = weight;
    }
}
