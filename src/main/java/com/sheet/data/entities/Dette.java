package com.sheet.data.entities;

public class Dette {
    private String date;
    private double montant;
    private String description;
    private Client client;

    public Dette() {
    }

    public Dette(String date, double montant, String description, Client client) {
        this.date = date;
        this.montant = montant;
        this.description = description;
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Dette{" +
                "date='" + date + '\'' +
                ", montant=" + montant +
                ", description='" + description + '\'' +
                ", client=" + client.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Dette dette = (Dette) o;

        if (Double.compare(dette.montant, montant) != 0)
            return false;
        if (date != null ? !date.equals(dette.date) : dette.date != null)
            return false;
        return description != null ? description.equals(dette.description) : dette.description == null;
    }
}