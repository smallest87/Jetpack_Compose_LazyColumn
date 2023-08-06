import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_lazycolumn.R
import com.example.jetpack_compose_lazycolumn.model.TemplateFieldWhatsappChat

@Composable
// Row Viewitem Abdus Salam
fun KumpulanViewProfil(templateFieldWhatsappChat: TemplateFieldWhatsappChat){

    Row(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .clickable {  },
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = templateFieldWhatsappChat.fotoProfil),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = templateFieldWhatsappChat.namaPengguna,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    letterSpacing = 0.5.sp
                )
                Text(
                    text = "05/08/2023",
                    fontSize = 12.sp,
                    letterSpacing = 0.2.sp,
                    color = Color(android.graphics.Color.parseColor("#878b8f"))
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = templateFieldWhatsappChat.cuplikanChat,
                    letterSpacing = 0.2.sp,
                    color = Color(android.graphics.Color.parseColor("#878b8f"))
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){

                    if(templateFieldWhatsappChat.pinned == true){

                        Image(
                            painter = painterResource(id = R.drawable.pinned),
                            colorFilter = ColorFilter.tint(color = Color(android.graphics.Color.parseColor("#878b8f"))),
                            contentDescription = null,
                            modifier = Modifier
                                .size(28.dp)
                                .padding(end = 8.dp)
                        )

                    }

                    if (templateFieldWhatsappChat.jumlahNotif > 0){

                        Box(
                            modifier = Modifier
//                            .size(24.dp)
                                .clip(RoundedCornerShape(25.dp))
                                .background(Color(android.graphics.Color.parseColor("#bc6669"))),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text=templateFieldWhatsappChat.jumlahNotif.toString(),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }

                    }


                }
            }
        }
    }

}
