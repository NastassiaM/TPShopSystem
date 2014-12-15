//package Classes.Entities;

import java.util.Objects;

public class User implements Comparable<User>
{

    private String login;
    private String password;
    private Position position;


    public User()
    {
        super();
    }


    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }


    public User(String login, String password, Position position)
    {
        this.login = login;
        this.password = password;
        this.position = position;
    }


    public User(String login, String password, String position)
    {
        this.login = login;
        this.password = password;
        if (Position.CLERK.toString().equalsIgnoreCase(position)) {
            this.position = Position.CLERK;
        }
        if (Position.SELLER.toString().equalsIgnoreCase(position)) {
            this.position = Position.SELLER;
        }
        if (Position.MANAGER.toString().equalsIgnoreCase(position)) {
            this.position = Position.MANAGER;
        }
    }


    public String getLogin()
    {
        return login;
    }


    public String getPassword()
    {
        return password;
    }


    public Position getPosition()
    {
        return position;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }


    public void setLogin(String login)
    {
        this.login = login;
    }


    public void setPosition(Position position)
    {
        this.position = position;
    }

    @Override
    public int compareTo(User o)
    {
        return ( login.compareTo(o.getLogin()) != 0 )?( login.compareTo(o.getLogin()) ):( password.compareTo(o.getPassword()) );
    }

    @Override
    public boolean equals(Object obj)
    {
        if ( this.compareTo((User)obj) == 0 )
        {
            return  true;
        }
        else
        {
            return  false;
        }
    }
}
