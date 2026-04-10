# Git Cheat Sheet

---

## 💡 Bonnes pratiques

* Faites des commit souvent avec des messages clairs
* Une branche par fonctionnalité
* Toujours faire un `git pull` avant de commencer
* Ne jamais travailler directement sur `main`
* Synchronisez-vous avec vos coéquipiers pour éviter les conflits lors de merge

---

## Vérifier l'état des fichiers

```bash
git status
```

Affiche les fichiers modifiés, mais non ajoutés ou non suivis.

```bash
git diff
```

Affiche les différences depuis le dernier commit. (à l'exception des nouveaux fichiers)

---

## Ajouter des fichiers

```bash
git add <fichier>
```

Ajoute un fichier spécifique.

```bash
git add .
```

Ajoute tous les fichiers modifiés.

---

## Créer un commit

```bash
git commit -m "Message clair"
```

Enregistre les modifications avec un message descriptif.

---

## Gérer les branches

Créer une branche :

```bash
git branch <nom-branche>
```

Changer de branche :

```bash
git checkout <nom-branche>
```

Créer + changer en une commande :

```bash
git checkout -b <nom-branche>
```

Lister les branches :

```bash
git branch
```

---

## Fusionner des branches

```bash
git merge <nom-branche>
```

Fusionne la branche spécifiée dans la branche actuelle.

---

## ⬆Envoyer vers le dépôt distant

```bash
git push
```

Envoie les commits vers le dépôt distant.

---

## ⬇Récupérer les modifications sur la branche courante

```bash
git pull
```

Récupère et fusionne les modifications distantes.

---

## Nettoyage & corrections

Annuler les modifications non ajoutées :

```bash
git checkout -- <fichier>
```

Retirer un fichier du staging :

```bash
git reset <fichier>
```

---

## Historique

```bash
git log
```

Affiche l'historique des commits.

---

## 🚀 Workflow simple

```bash
git pull
git checkout -b feature/ma-feature
# coder...
git add .
git commit -m "Ajoute ma feature"
git push -u origin feature/ma-feature
```

---

Bon code ! 😄
