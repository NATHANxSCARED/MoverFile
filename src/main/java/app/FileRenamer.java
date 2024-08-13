package app;

import java.io.File;

public class FileRenamer {

    public static void main(String[] args) {
        String sourceDirectory = "D:\\video";
        String destinationDirectory = "C:\\Users\\frux\\Documents\\video_gets_25.05.2024";

        File sourceFolder = new File(sourceDirectory);
        File[] files = sourceFolder.listFiles();

        if (files != null && files.length > 0) {
            int counter = 1;

            for (File file : files) {
                if (file.isFile()) {
                    String extension = getFileExtension(file);
                    String newFileName = String.format("vidéo_%02d%s", counter, extension);

                    File newFile = new File(destinationDirectory + "//" + newFileName);
                    boolean success = file.renameTo(newFile);

                    if (success) {
                        System.out.println(file.getName() + " a été renommé et déplacé vers " + newFile.getPath());
                    } else {
                        System.out.println("Erreur lors du déplacement de " + file.getName());
                    }
                    counter++;
                }
            }
        } else {
            System.out.println("Le dossier source est vide ou introuvable.");
        }
    }

    // Méthode pour extraire l'extension de fichier
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // Si le fichier n'a pas d'extension
        }
        return fileName.substring(lastIndexOf);
    }
}
