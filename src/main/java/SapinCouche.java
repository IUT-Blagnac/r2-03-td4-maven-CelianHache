
/**
 * Décrivez votre classe SapinCouche ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class SapinCouche
{
    /**
     * permet de retourner une chaîne de caractères avec nbr caractères carac identiques
     * @param nbr  nombre de caractères de la chaîne
     * @param carac caractère constituant la chaîne
     * @return la chaîne de caractères de nbr caractères carac
     */
    public static String genererLigneCouchee (int nbr, char carac) 
    {
        String ligne = "";
        for (int colonne=1;colonne<=nbr;colonne+=1) 
        {
            ligne+= carac;
        }
        return ligne;
    }
    /**
     * permet de retourner une chaîne de caractères représentant le sapin couché demandé
     * @param hauteur :  hauteur du sapin
     * @return la chaîne de caractères sapin couché
     */
    public static void genererSapinCouche(int hauteur) 
    {
        String sapin ="";
        int cpt=0 ;
        for (int ligne=1;ligne<=2*hauteur-1;ligne+=1)
        {
            if ( ligne < hauteur )
            {
                sapin += genererLigneCouchee (ligne, '*') + '\n';
            }
            else 
            {
                 sapin+= genererLigneCouchee (ligne - cpt, '*') + '\n';
                 cpt +=2;
            };
        }
        System.out.println(sapin);
    }
    /**
     * Programme principal qui renvoie la chaine de caractère contenant un sapin couché
     * @param hauteur la hauteur du sapin
     */
    public static void sapinCouche (int hauteur)
    {
        String sapin = "";
        int cpt=0;
        for (int ligne=1;ligne<=hauteur*2-1;ligne+=1)
        {
            if (ligne < hauteur)
            {
                for (int colonne=1; colonne <=ligne; colonne++)
                {
                    sapin += "x";
                }
                sapin += '\n';
            }
            else 
            {
                for (int colonne=1; colonne<=ligne - cpt;colonne++)
                {
                    sapin += "x";
                }
                sapin += '\n';
                cpt+=2;
            }
        }
        System.out.println(sapin);
    }
}
