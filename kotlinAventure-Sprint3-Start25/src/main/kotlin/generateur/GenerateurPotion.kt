package generateur

import model.item.Potion
import java.nio.file.Files
import java.nio.file.Paths

class GenerateurPotion (val cheminFichier: String) {
    /**
     * Génère et retourne un mapping des qualités à partir des données contenues dans le fichier CSV.
     *
     * @return Un mapping des qualités où la clé est le nom de la qualité en minuscules et la valeur est un objet Qualite.
     */
    fun generer(): MutableMap<String, Potion> {
        val mapObjets = mutableMapOf<String, Potion>()

        // Lecture du fichier CSV, le contenu du fichier est stocké dans une liste mutable :
        val cheminCSV = Paths.get(this.cheminFichier)
        val listeObjCSV = Files.readAllLines(cheminCSV)

        // Instance des objets :
        for (i in 1..listeObjCSV.lastIndex) {
            val ligneObjet = listeObjCSV[i].split(";")
            val cle = ligneObjet[0].lowercase()
            val objet = Potion(nom = ligneObjet[0], description = ligneObjet[1], soin= ligneObjet[2].toInt())
            mapObjets[cle] = objet
        }
        return mapObjets
    }
}