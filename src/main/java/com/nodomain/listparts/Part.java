package com.nodomain.listparts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Part
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;             // ИН, автогенерация

    private String name;            // Наименование комплектующего

    private Boolean isNecessary;    // Признак "необходимости"

    private Long amount;         // Кол-во на складе

    protected Part()
    {
        //this(null,null,null);
    }

    public Part(String name, Boolean isNecessary, Long amount)
    {
        this.name = name;
        this.isNecessary = isNecessary;
        this.amount = amount;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Boolean getNecessary()
    {
        return isNecessary;
    }

    public void setNecessary(Boolean necessary)
    {
        isNecessary = necessary;
    }

    public Long getAmount()
    {
        return amount;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isNecessary=" + isNecessary +
                ", amount=" + amount +
                '}';
    }
}
