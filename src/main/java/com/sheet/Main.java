package com.sheet;

import java.util.Scanner;

import com.sheet.core.factory.FactoryRepo;
import com.sheet.core.factory.FactoryServ;
import com.sheet.services.ArticleServ;
import com.sheet.services.DetteServ;
import com.sheet.services.UserServ;
import com.sheet.views.ArticleView;
import com.sheet.views.DetteView;
import com.sheet.views.UserView;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    // ----------------------------------------------------------------------
    public static int showMenu(Scanner scanner) {
        System.out.println("1 - Creer un compte au client");
        System.out.println("2 - Creer compte (Admin ou Boutiquier)");
        System.out.println("3 - Desactiver ou Activer un compte");
        System.out.println("4 - Afficher les comptes actifs");
        System.out.println("5 - Creer un aticle");
        System.out.println("6 - Afficher les articles");
        System.out.println("7 - Afficher les articles disponibles");
        System.out.println("8 - Mettre à jour quantite stock d'un article");
        System.out.println("9 - Archiver les dettes soldées");
        System.out.println("10 - Quitter");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static void main(String[] args) {
        // Design Pattern: Factory ----------------------------------------------
        FactoryRepo factoryRepo = new FactoryRepo();
        FactoryServ factoryServ = new FactoryServ(factoryRepo.getInstanceOfClientRepo(),
                factoryRepo.getInstanceOfUserRepo(),
                factoryRepo.getInstanceOfArticleRepo(), factoryRepo.getInstanceOfDetteRepo());

        // ----------------------------------------------------------------------
        // ClientServ clientServ = factory.getInstanceOfClientServ();
        UserServ userServ = factoryServ.getInstanceOfUserServ();
        ArticleServ articleServ = factoryServ.getInstanceOfArticleServ();
        DetteServ detteServ = factoryServ.getInstanceOfDetteServ();
        // ----------------------------------------------------------------------
        UserView userView = new UserView(scanner, factoryServ.getInstanceOfUserServ(), factoryServ.getInstanceOfClientServ());
        ArticleView articleView = new ArticleView(scanner, factoryServ.getInstanceOfArticleServ())  ;
        DetteView detteView = new DetteView(scanner, factoryServ.getInstanceOfDetteServ());

        int choice;
        do {
            choice = showMenu(scanner);
            switch (choice) {
                case 1:
                    userServ.createAccount(userView.saisieFromClient());
                    break;
                case 2:
                    userServ.createAccount(userView.saisie());
                    break;
                case 3:
                    userServ.toggleUser(userView.ActiveOrDesactive());
                    break;
                case 4:
                    userView.showUsers(userServ.findActiveUsers());
                    break;
                case 5:
                    articleServ.createArticle(articleView.saisie());
                    break;
                case 6:
                    articleView.showArticles(articleServ.findArticles());
                    break;
                case 7:
                    articleView.showArticles(articleServ.findArticlesDisponible());
                    break;
                case 8:
                    articleServ.updateArticle(articleView.UpdateQteStock());
                    break;
                case 9:
                    detteServ.ArchivedDette(detteView.ArchivedValidateDette());
                    break;
                case 10:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }

        } while (choice != 10);
    }
}