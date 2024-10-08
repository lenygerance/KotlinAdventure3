package model.personnage

import model.item.Arme
import model.item.Item

class Monstre (
    nom: String,
    pointDeVie: Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    armeEquipee: Arme?,
    inventaire : MutableList<Item> = mutableListOf()
) : Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armeEquipee, inventaire = inventaire)  {
}