package generateur


import armes
import armures
import bombes
import model.item.Item
import model.personnage.Monstre
import potions
import java.nio.file.Files
import java.nio.file.Paths

class GenerateurMonstre (val cheminFichier: String) {
    /**
     * Génère et retourne un mapping des qualités à partir des données contenues dans le fichier CSV.
     *
     * @return Un mapping des qualités où la clé est le nom de la qualité en minuscules et la valeur est un objet Qualite.
     */
    fun generer(): MutableMap<String, Monstre> {
        val mapObjets = mutableMapOf<String, Monstre>()

        // Lecture du fichier CSV, le contenu du fichier est stocké dans une liste mutable :
        val cheminCSV = Paths.get(this.cheminFichier)
        val listeObjCSV = Files.readAllLines(cheminCSV)

        // Instance des objets :
        for (i in 1..listeObjCSV.lastIndex) {
            val ligneObjet = listeObjCSV[i].split(";")
            val cle = ligneObjet[0].lowercase()

            val stringInventaire = ligneObjet[8]
            val listStringItem = stringInventaire.split(",")
            val inventaireItem = mutableListOf<Item>()
            for (stringItem in listStringItem) {
                if (stringItem in armes ) inventaireItem.add(armes[stringItem]!!)
                if (stringItem in armures) inventaireItem.add(armures[stringItem]!!)
                if (stringItem in potions) inventaireItem.add(potions[stringItem]!!)
                if (stringItem in bombes) inventaireItem.add(bombes[stringItem]!!)
            }

            val objet = Monstre(nom = ligneObjet[0], pointDeVie = ligneObjet[1].toInt(),
                pointDeVieMax = ligneObjet[2].toInt(), attaque = ligneObjet[3].toInt(), defense = ligneObjet[4].toInt(),
                endurance = ligneObjet[5].toInt(), vitesse = ligneObjet[6].toInt(), armeEquipee = armes[ligneObjet[7]], inventaire = inventaireItem )
            mapObjets[cle] = objet
        }
        return mapObjets
    }
}