package com.example.lazycolumn

import android.content.Context
import android.media.Image
import android.provider.ContactsContract.Profile
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Thin
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazycolumn.ui.theme.LazyColumnTheme
import org.w3c.dom.Text

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileLayout(){
    LazyColumn(content = {
       items(getDataList()){ items->
           com.example.lazycolumn.Profile(img = items.Img, title = items.title, compmany = items.compmany)

       }
    })
    }



@Composable
fun Profile(img:Int,title:String,compmany:String){
    val context = LocalContext.current

    Card( elevation = CardDefaults.cardElevation(
        defaultElevation = 6.dp

    ),
        modifier = Modifier.padding(8.dp).clickable {
            Toast.makeText(context,title,Toast.LENGTH_SHORT).show()
        }){
        Row( verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)) {
            Image(painter = painterResource(id = img), contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(48.dp)
                        .weight(2f)
                    )
            Item_Description(title, compmany,Modifier.weight(8f))
        }
    }

}

@Composable
private fun Item_Description(title: String, compmany: String,modifier: Modifier) {
    Column(modifier = modifier)
    {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = compmany,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = Thin
        )
    }
}

data class data(val Img:Int,val title: String,val compmany: String)

fun getDataList(): MutableList<data> {
    val list = mutableListOf<data>()
    list.add(data(R.drawable.profile_1, "Programming", "Microsoft"))
    list.add(data(R.drawable.profile_2,"Analytics","Salesforce"))
    list.add(data(R.drawable.profile_3, "Data Analyst", "Uber"))
    list.add(data(R.drawable.profile_2,"Android App Developer","Deloitte"))
    list.add(data(R.drawable.profile_3, "Cooking", "Sodexo"))
    list.add(data(R.drawable.profile_1,"Cab","Ola"))
    list.add(data(R.drawable.profile_3, "Food Volg", "Youtube"))
    list.add(data(R.drawable.profile_2,"Marketing","Bujyus"))
    list.add(data(R.drawable.profile_3, "Gym", "Muscle Studio"))
    list.add(data(R.drawable.profile_2,"Content Creator","Instagram"))
    list.add(data(R.drawable.profile_1, "Programming", "Microsoft"))
    list.add(data(R.drawable.profile_2,"Analytics","Salesforce"))
    list.add(data(R.drawable.profile_3, "Data Analyst", "Uber"))
    list.add(data(R.drawable.profile_2,"Android App Developer","Deloitte"))
    list.add(data(R.drawable.profile_3, "Cooking", "Sodexo"))
    list.add(data(R.drawable.profile_1,"Cab","Ola"))
    list.add(data(R.drawable.profile_3, "Food Volg", "Youtube"))
    list.add(data(R.drawable.profile_2,"Marketing","Bujyus"))
    list.add(data(R.drawable.profile_3, "Gym", "Muscle Studio"))
    list.add(data(R.drawable.profile_2,"Content Creator","Instagram"))

    return list

}

