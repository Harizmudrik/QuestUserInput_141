package com.example.prak4pam_141

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Preview(showBackground = true)
@Composable
fun Input(modifier: Modifier = Modifier) {

    var Nama by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var Gender by remember { mutableStateOf("") }

    var dataGender = listOf("Laki-Laki", "Perempuan")

    var ConfNama by remember { mutableStateOf("") }
    var ConfEmail by remember { mutableStateOf("") }
    var Confalamat by remember { mutableStateOf("") }
    var Confnotelepon by remember { mutableStateOf("") }
    var ConfGender by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = Nama,
            onValueChange = { Nama = it },
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text(text = "Isi Nama Anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)

        )
        Row (modifier = Modifier.fillMaxWidth()){
            dataGender.forEach { selectedGender ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = Gender == selectedGender,
                        onClick = { Gender = selectedGender }
                    )
                    Text(text = selectedGender)}
            }

        }

        TextField(
            value = Email,
            onValueChange = {Email = it},
            label = {
                Text(text = "Email")
            },
            placeholder = { Text(text = "Isi Email Anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "alamat")
            },
            placeholder = { Text(text = "Isi alamat Anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)

        )

        TextField(
            value = notelepon,
            onValueChange = {notelepon = it},
            label = {
                Text(text = "notelepon")
            },
            placeholder = { Text(text = "Isi notelepon Anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            ConfNama = Nama
            ConfEmail = Email
            Confalamat = alamat
            Confnotelepon = notelepon
            ConfGender = Gender
        }) {
            Text(text = "Simpan")
        }
        TampilData(param = "Nama",
            arg = ConfNama)
        TampilData(param = "Email",
            arg = ConfEmail)
        TampilData(param = "alamat",
            arg = ConfEmail)
        TampilData(param = "notelepon",
            arg = Confnotelepon)
        TampilData(param = "Gender",
            arg = ConfGender)

    }
}

@Composable
fun TampilData(
    param:String,arg:String
){
    Column (modifier = Modifier.padding(16.dp)) {
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = param, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.1f))
            Text(text = arg, modifier = Modifier.weight(2f))
        }
    }
}