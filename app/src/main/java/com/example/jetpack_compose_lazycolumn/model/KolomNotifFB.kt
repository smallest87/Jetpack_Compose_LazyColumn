package com.example.jetpack_compose_lazycolumn.model

data class KolomNotifFB(
    val id: Int,
    val notifDari: String,
    val aktivitas: String,
    val namaObyekString: String,
    val waktuNotifString: String,
    val fotoNotifImage: Int = 0
)

data class KolomProfil(
    val id: Int,
    val namaProfil: String,
    val bioData: String,
    val fotoProfil: Int = 0
)

data class TemplateFieldWhatsappChat(
    val id: Int,
    val namaPengguna: String,
    val cuplikanChat: String,
    val pinned: Boolean,
    val bisukan: Boolean,
    val jumlahNotif: Int,
    val fotoProfil: Int = 0
)

data class TemplateFieldWhatsappUserProfile(
    val id: Int,
    val fotoProfil: Int = 0,
    val nomorPengguna: String,
    val namaPengguna: String,
    val statusBisukan: Boolean,
)
