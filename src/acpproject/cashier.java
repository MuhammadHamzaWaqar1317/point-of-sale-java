package acpproject;

/**
 *
 * @author hp
 */
public class cashier
{
    private String name;
    private String email;
    private int id;
    private String pass;

    public cashier()
    {
        name="";
        pass="cashier";
        id=1;
        email="cashier";
    }

    public cashier(String name, String email, int id, String pass)
    {
        this.name = name;
        this.email = email;
        this.id = id;
        this.pass = pass;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }
    
    
       
}
