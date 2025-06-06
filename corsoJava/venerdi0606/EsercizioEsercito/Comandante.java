package venerdi0606.EsercizioEsercito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Comandante {
    String nome;
    int budget;
    List<Soldato> esercito;
    int guadagniTotali;

    public Comandante(String nome, int budget, int guadagniTotali){
        this.nome = nome;
        this.budget = budget;
        this.guadagniTotali = guadagniTotali;

        esercito = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Soldato> getEsercito() {
        return esercito;
    }

    public void setEsercito(List<Soldato> esercito) {
        this.esercito = esercito;
    }

    public int getGuadagniTotali() {
        return guadagniTotali;
    }

    public void setGuadagniTotali(int guadagniTotali) {
        this.guadagniTotali = guadagniTotali;
    }

    public void arruolaSoldato(Soldato s){
        esercito.add(s);
        perdiSoldi(s.getCosto());
    }

    public void combatti(List<Soldato> esercitoNemico, int turno){      // la lista in ingresso è quella dei nemici
        if(esercitoNemico.size() == 0){
            System.out.println("Non ci sono nemici da combattere!");
            return;
        }
        if(esercito.size() == 0){
            System.out.println("Non hai soldati da combattere!");
            return;
        }

        System.out.println("Alle armi marrani!");
        // implementazione tutti contro tutti
        Random random = new Random();
    
        int sceltaSoldatoAlleato = random.nextInt(esercito.size());
        int sceltaSoldatoNemico = random.nextInt(esercitoNemico.size());

        Soldato soldatoAlleato = esercito.get(sceltaSoldatoAlleato);
        Soldato soldatoNemico = esercitoNemico.get(sceltaSoldatoNemico);

        int attaccoAlleato = soldatoAlleato.attacca();
        int attaccoNemico = soldatoNemico.attacca();

        if(attaccoAlleato > attaccoNemico){
            int attaccoAlleatoEffettivo = attaccoAlleato - attaccoNemico;
            if(attaccoAlleatoEffettivo >= soldatoNemico.getSalute()){
                esercitoNemico.remove(sceltaSoldatoNemico);
                guadagna(20);
            } else { 
                soldatoNemico.setSalute(soldatoNemico.getSalute() - attaccoAlleatoEffettivo); 
            }
        } else if (attaccoAlleato == attaccoNemico){
            System.out.println("Stretta di mano");
        } else {
            System.out.println("Sono stanco capo, il nemico è troppo forte.");
        }

        if(turno%3==0){
            guadagna(esercito);
        }
    }

    public void guadagna(int soldi){
        guadagniTotali += soldi;
        budget += soldi; 
    }

    public void guadagna(List<Soldato> esercito){   // overload del metodo guadagna
        for(int i = 0; i < esercito.size(); i++){
            guadagniTotali += 10;
            budget += 10;
        }
    }

    public int calcolaGuadagniTotali(){
        return guadagniTotali;
    }

    public void perdiSoldi(int costo){
        if(budget < costo){
            budget = 0;
        }
        budget -= costo;
    }

    boolean isSconfitto(){
        if(esercito.size() == 0){
            return true;
        } else return false;
    }
}
