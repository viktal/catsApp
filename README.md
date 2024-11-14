# Cats App

Cats App is an Android application that displays information about different cat breeds using [The Cat API](https://thecatapi.com). 

## Features

- **List of Cats**: Displays a list of cats with an image, breed name, and country of origin.
- **Breed Details**: Tapping on a breed opens a detailed view with additional information, including the breed’s country, description, and temperament.

![cats app](https://github.com/user-attachments/assets/83f021b4-5f03-467f-a56d-52faf42074ac)


## Technologies

- **Jetpack Compose**
- **Kotlin Coroutines & Flow**
- **Retrofit**
- **Jetpack ViewModel**
- **Paging 3**
- **Jetpack Navigation**

## Project Structure

- **:app**: the main application module.
- **:core:data**: data handling logic, including data repositories.
- **:core:cats-api**: handles API interactions with The Cat API, managing network requests.
- **:features:cats**: the main feature for displaying the list of cats and breed details.
