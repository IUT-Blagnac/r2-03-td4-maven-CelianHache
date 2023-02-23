
/**
 * TP4
 *
 * @celian
 */
import java.util.Scanner;
public class Sapins
{
    /**
     * permet de retourner une chaîne de caractères avec nbr caractères carac identiques
     * @param nbr  nombre de caractères de la chaîne
     * @param carac caractère constituant la chaîne
     * @return la chaîne de caractères de nbr caractères carac
     */
    public static String genererLignePleine (int nbrCarac, char carac) 
    {
        String ligne = "";
        for (int cptCarac=0;cptCarac<nbrCarac;cptCarac+=1) {
            ligne += carac;
        }
        return ligne;
    }
    /**
     * permet de retourner une chaîne de caractères représentant le sapin plein demandé
     * @param hauteur :  hauteur du sapin
     * @return la chaîne de caractères sapin plein
     */
    public static void genererSapinPlein (int h) 
    {
        String sapin = "";
        for (int cptLigne=1;cptLigne<=h;cptLigne+=1)
        {
            for (int cptColonne=1;cptColonne<=h-cptLigne;cptColonne+=1)
            {
                sapin+=" ";
            }
            sapin += genererLignePleine (2*cptLigne-1, '*') + '\n';
        }
        System.out.println(sapin);
    }
    /**
     * permet de retourner une chaîne de caractères représentant un étage du sapin vide 
     * @param nbr  nombre de caractères de la chaîne
     * @param carac caractère constituant la chaîne
     * @return la chaîne de caractères 
     */
    public static String genererLigneVide (int nbcaract, int hauteur, char carac) 
    {
        String ligne = "";
        if (nbcaract==1)  
        {
        ligne += carac;
        }
        else if (nbcaract==(2*hauteur-1))
        {
            for (int cptCarac=0;cptCarac<nbcaract;cptCarac+=1)
            {
                ligne += carac;
            }
        }
        else
        {
            ligne += carac ;
            for (int cptCarac=0;cptCarac<nbcaract-2;cptCarac+=1)
            {
                ligne += " ";
            }
            ligne += carac ;
        }
        return ligne;
    }
    /**
     * permet de retourner une chaîne de caractères représentant le sapin vide demandé
     * @param hauteur :  hauteur du sapin
     * @return la chaîne de caractères sapin vide
     */
    public static void genererSapinVide (int hauteur) 
    {
        String sapin = "";
        for (int ligne=1;ligne<=hauteur;ligne+=1)
        {
            for (int colonne=1;colonne<=hauteur-ligne;colonne+=1)
            {
                sapin += " ";
            }
            sapin += genererLigneVide (2*ligne-1,hauteur, '*') + '\n';
        }
        System.out.println(sapin);
    }
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
     * permet de retourner une chaine de caractère représentant un écran barré
     * @param dimension : dimension de l'écran
     * @affiche l'écran
     */
    public static void genererMatriceEcranBarre (int dimension)
    {
        String ecran = "";
        for (int ligne = 1; ligne <= dimension ; ligne += 1)
        {
            ecran += genererLigneEcran ( ligne, dimension, '*', '0') + '\n';
        }
        System.out.println(ecran);
    }
    public static String genererLigneEcran ( int ligne, int dimension, char carac1, char carac2)
    {
        String ligneMatrice = "";
        if (ligne == 1 || ligne == dimension)
        {
            for (int colonne=1;colonne<=dimension;colonne+=1)
            {
                ligneMatrice += carac1;
            }
        }
        else 
        {
            for (int colonne=1;colonne<=dimension;colonne+=1)
            {
                if (colonne == 1 || colonne == dimension || colonne == ligne 
                    || colonne == dimension - ligne + 1)
                {
                    ligneMatrice += carac1 ;
                }
                else
                {
                    ligneMatrice += carac2 ;
                }
            }
        }
        return ligneMatrice;
    }

    /*
     * Programme main qui lance une interface de discussion
     * etre la machine et l'utilisateur
     */
    public static void main (String Args[])
    {
        Scanner clavier = new Scanner(System.in) ;
        System.out.println("Quelle figure voulez-vous afficher ?");
        String reponse  = clavier.nextLine();
        while ((reponse.equals("sapin"))== false && (reponse.equals("écran")) == false)
        {
            System.out.println("Choisissez entre sapin et écran.");
            reponse  = clavier.nextLine();
        }
        if (reponse.equals("écran"))
        {
            System.out.println("Donnez la dimension de votre écran.");
            int dimension = clavier.nextInt();
            genererMatriceEcranBarre(dimension);
        }
        else
        {
            System.out.println("Voulez-vous un sapin plein, vide ou couché ?");
            reponse = clavier.nextLine();
            while ((reponse.equals("couché"))== false && (reponse.equals("vide")) == false
                    && reponse.equals("plein")==false)
            {
                System.out.println("Choisissez entre couché, plein et vide.");
                reponse  = clavier.nextLine();
            }
            System.out.println("Donnez la hauteur de votre sapin.");
            int hauteur  = clavier.nextInt();
            while (hauteur<0)
            {
                System.out.println("Renseignez une hauteur positive !");
                hauteur  = clavier.nextInt();
            }
            if (reponse.equals("couché"))
            {
                genererSapinCouche(hauteur);
            }
            else
            {
                if (reponse.equals("plein"))
                {
                    genererSapinPlein(hauteur);
                }
                else
                {
                    genererSapinVide(hauteur);
                }
            }
        }
    }
}


