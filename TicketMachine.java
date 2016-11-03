/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // Variable para guardar si se entra en modo premio o no.
    private boolean prize;
    //Variable para guardar el max de billetes a vender.
    private int contador;
    //Variable acumuladora para contar los billetes vendidos.
    private int acumulado;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, boolean premio, int count)
    {
        //Comprobamos si se entra en modo premio o no.
        if(premio == false){
            price = cost;
            balance = 0;
            total = 0;
            acumulado = 0;
            prize = premio;
            contador = count;
        }
        else{
            price = cost;
            balance = 0;
            total = 0;
            acumulado = 0;
            prize = premio;
            System.out.println("Modo con premio seleccionado.");
            contador = count;
        }
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            if(acumulado < contador){
                if(prize == false){
                    // Simulate the printing of a ticket.
                    System.out.println("##################");
                    System.out.println("# The BlueJ Line");
                    System.out.println("# Ticket");
                    System.out.println("# " + price + " cents.");
                    System.out.println("##################");
                    System.out.println();
        
                    // Update the total collected with the price.
                    total = total + price;
                    // Reduce the balance by the prince.
                    balance = balance - price;
                    
                    acumulado = acumulado + 1;
                }
                else{
                    // Simulate the printing of a ticket.
                    System.out.println("##################");
                    System.out.println("# The BlueJ Line");
                    System.out.println("# Ticket");
                    System.out.println("# " + price + " cents.");
                    System.out.println("##################");
                    System.out.println();
                    
                    
                    acumulado = acumulado + 1;
                    
                    /**
                     * A los billetes de regalo no les afecta el contador de venta de billetes.
                       */
                    System.out.println("##################");
                    System.out.println("# The BlueJ Line");
                    System.out.println("# ¡Ticket de regalo!");
                    System.out.println("# Ticket");
                    System.out.println("# 0 cents.");
                    System.out.println("##################");
                    System.out.println();
                      
                                            
                    // Update the total collected with the price.
                    total = total + price;
                    // Reduce the balance by the prince.
                    balance = balance - price;
                    
                    
                }
            }
            else{
                System.out.println("Maximo venta de billetes excedido.");
            }
        }
        else {
            int amountLetMoney;
            amountLetMoney = price -balance;
            System.out.println("You must insert at least: " +
                               amountLetMoney + " more cents.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    /**
     * El metodo devuelve el dinero total acumulado en el dia si no hay una operacion en curso,
     * si hay una operacion en curso devuelve un error en forma de -1.
       */
    public int emptyMachine()
    {
        if(balance == 0){
            int amountTotal;
            amountTotal = total;
            total = 0;
            System.out.println("Total dinero acumulado en el dia: " + amountTotal + " Euros");
            return amountTotal;
        }
        else{
            return -1;
        }
    }
}
