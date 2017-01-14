/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Grupo 01
 */
public class JugadorHumano extends Jugador{

    @Override
    public Carta jugar() {
    try {
        Thread.sleep (10000);
        } catch (Exception e) {
        // Mensaje en caso de que falle
        }
        return null;
    }

    @Override
    public void pasar() {
    }

    @Override
    public String getModo() {
        return "Humano";
    }

    
}
