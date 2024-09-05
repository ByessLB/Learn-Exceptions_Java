# Les exceptions

## Introduction

### Qu'est ce qu'une Exception ?

Une exception est un événement qui interrompt le flux normal d'exécution d'un programme. Les exceptions sont utilisées pour signaler des erreurs ou des conditions exceptionnelles qui nécessitent une attention particulière. En java, les exceptions sont des objets qui héritent de la classe `java.lang.Throwable`.

### Pourquoi utiliser des Exceptions ?

Les exceptions permettent de gérer les erreurs de manière structurée et de séparer le code de gestion des erreurs du code principal. Elles facilitent la détection et la correction des errreurs, améliorant la robustesse et la maintenabilité du code.

## Types d'Exceptions

### Exceptions Vérifiées (Checked Exceptions)

Les exceptions vérifiées sont des exceptions que le compilateur oblige à gérer ou à déclarer. Elles héritent de la classe `java.lang.Exception` mais pas de `java.lang.RuntimeException`.

Exemples :
- `IOException`
- `SQLException`

### Exceptions Non Vérifiées (Unchecked Exceptions)

Les exceptions non vérifiées sont des exceptions que le compilateur n'oblige pas à gérer ou à déclarer. Elles héritent de la classe `java.lang.RuntimeException`.

Exemples :
- `NullPointerException`
- `ArrayIndexOutOfBoundsException`

### Exceptions d'Erreur (Errors)

Les erreurs sont des exceptions qui indiquent des problèmes graves qui ne peuvent généralement pas être récupérés. Elles héritent de la calsse `java.lang.Error`.

Exemples :
- `OutOfMemoryError`
- `StackOverflowError`

## Gestion des Exceptions

### Block `try-catch`

Le block `try-catch` est utilisé pour gérer les exceptions. Le code susceptible de lever une exception est placé dans le code `try`, et le code de gestion des exceptions est placé dans le bloc `catch`.
```java
public class Main {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // Cela lèvera une ArithmeticException
            System.out.println("Résultat : " + result);
        } catch (ArithmeticException e) {
            System.out.println("Erreur : Division par zéro.");
        }
    }
}
```

### Block `finally`

Le block `finally` est utilisé pour exécuter du code qui doit être exécuté quelle que soit l'exception levée. Il est souvent utilisé pour libérer des ressources.
```java
public class Main {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // Cela lèvera une ArithmeticException
            System.out.println("Résultat : " + result);
        } catch (ArithmeticException e) {
            System.out.println("Erreur : Division par zéro.");
        } finally {
            System.out.println("Ce bloc est toujours exécuté.");
        }
    }
}
```

### Block `try-catch-resources`

Le bloc `rey-catch-resources` est utilisé pour gérer automatiquement lla fermeture des resources qui implémentent ll'interface `AutoCloseable`.
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("fichier.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Erreur : lecture du fichier.");
        }
    }
}
```

## Création d'Exceptions Personnalisées

### Définition d'une Exception Personnalisée

Pour créer une exception personnalisée, il suffit de définir une nouvelle classe qui hérite de `java.lang.Exception` ou de l'une de ses sous-classes.
```java
public class MonException extends Exception {
    public MonException(String message) {
        super(message);
    }
}
```

### Utilisation d'une Exception Personnalisée
```java
public class Main {
    public static void main(String[] args) {
        try {
            methodeQuiPeutLeverException();
        } catch (MonException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void methodeQuiPeutLeverException() throw MonException {
        throw new MonException("Une erreur personnalisée s'est produite.");
    }
}
```

### Excepiton Vérifiées et Non Vérifiées Personnalisées

Pour créer une exception vérifiée personnalisée, héritez de `java.lang.Exception`.
```java
public class MonExceptionVerifiee extends Exception {
    public MonExceptionVerifiee(String message) {
        super(message);
    }
}
```

Pour créer une exception non vérifiée personnalisée, héritez de `java.lang.Exception`.
```java
public class MonExceptionNonVerifiee extends RuntimeException {
    public MonExceptionNonVerifiee(String message) {
        super(message);
    }
}
```

## Bonnnes Pratiques

### Utilisation des Exceptions

- **Spécificité** : Utilisez des exceptions spécifiques plutôt ques des exceptions génériques.
- **Documentation** : Documentez les exceptions que vos méthodes peuvent lever.
- **Gestion** : Gérez les exceptions au niveau approprié et évitez de les ignorer.

### Création des Exceptions

- **Nom** : Choisissez un nom significatif pour votre exception.
- **Message** : Fournissez des messages d'erreur informatifs.
- **Héritage** : Héritez de la classe appropriée (`Exception` pour les exceptions vérifiées, `RuntimeException` pour les exceptions non vérifiées).

## Conclusion

Les exceptions en Java sont un mécanisme puissant pour gérer les erreurs et les conditions exceptionnelles. En utilisant les exceptions vérifiées, non vérifiées et les erreurs, vous pouvez structurer votre code de manière robuste et maintenable. La création d'exceptions personnalisées permet de définir des erreurs spécifiques à votre application, facilitant ainsi la gestion et la compréhension des erreurs.