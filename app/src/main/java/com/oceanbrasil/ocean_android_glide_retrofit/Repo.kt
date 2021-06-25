package com.oceanbrasil.ocean_android_glide_retrofit

class Repo (
    val items: List<Repository>
)

data class Owner (
    val login: String,
    val avatar_url: String
)

data class Repository (
    val name: String,
    val owner: Owner
    )