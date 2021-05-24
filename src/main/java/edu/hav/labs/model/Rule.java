package edu.hav.labs.model;
/*
  @author   Bohdana Havaleshko
  @project   coursework
  @enum  Rule
  @version  1.0.0
  @since 20.04.2021
*/

public enum Rule {
    READONLY("Тільки читання в бібліотеці"),
    TERM7("Термін видачі - 7 днів"),
    TERM14("Термін видачі - 14 днів"),
    TERM30("Термін видачі - 30 днів"),
    ORDERONLY("Тільки за предзамовленням");



    private final String rule;
    Rule(String rule){
        this.rule = rule;
    }

    public String getRule(){ return rule;}
}
