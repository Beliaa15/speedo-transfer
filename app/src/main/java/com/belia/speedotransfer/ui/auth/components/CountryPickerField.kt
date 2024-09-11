package com.belia.speedotransfer.ui.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.belia.speedotransfer.R
import com.belia.speedotransfer.ui.theme.GrayG10
import com.belia.speedotransfer.ui.theme.GrayG100
import com.belia.speedotransfer.ui.theme.GrayG70
import com.belia.speedotransfer.ui.theme.GrayG700
import com.belia.speedotransfer.ui.theme.RedP300
import com.belia.speedotransfer.ui.theme.RedP50
import com.belia.speedotransfer.ui.theme.bodyMedium16
import com.belia.speedotransfer.ui.theme.bodyRegular16
object Countries {
    val nameWithFlags = listOf(
        "Afghanistan" to "https://flagsapi.com/AF/flat/64.png",
        "Albania" to "https://flagsapi.com/AL/flat/64.png",
        "Algeria" to "https://flagsapi.com/DZ/flat/64.png",
        "Andorra" to "https://flagsapi.com/AD/flat/64.png",
        "Angola" to "https://flagsapi.com/AO/flat/64.png",
        "Antigua and Barbuda" to "https://flagsapi.com/AG/flat/64.png",
        "Argentina" to "https://flagsapi.com/AR/flat/64.png",
        "Armenia" to "https://flagsapi.com/AM/flat/64.png",
        "Australia" to "https://flagsapi.com/AU/flat/64.png",
        "Austria" to "https://flagsapi.com/AT/flat/64.png",
        "Azerbaijan" to "https://flagsapi.com/AZ/flat/64.png",
        "Bahamas" to "https://flagsapi.com/BS/flat/64.png",
        "Bahrain" to "https://flagsapi.com/BH/flat/64.png",
        "Bangladesh" to "https://flagsapi.com/BD/flat/64.png",
        "Barbados" to "https://flagsapi.com/BB/flat/64.png",
        "Belarus" to "https://flagsapi.com/BY/flat/64.png",
        "Belgium" to "https://flagsapi.com/BE/flat/64.png",
        "Belize" to "https://flagsapi.com/BZ/flat/64.png",
        "Benin" to "https://flagsapi.com/BJ/flat/64.png",
        "Bhutan" to "https://flagsapi.com/BT/flat/64.png",
        "Bolivia" to "https://flagsapi.com/BO/flat/64.png",
        "Bosnia and Herzegovina" to "https://flagsapi.com/BA/flat/64.png",
        "Botswana" to "https://flagsapi.com/BW/flat/64.png",
        "Brazil" to "https://flagsapi.com/BR/flat/64.png",
        "Brunei" to "https://flagsapi.com/BN/flat/64.png",
        "Bulgaria" to "https://flagsapi.com/BG/flat/64.png",
        "Burkina Faso" to "https://flagsapi.com/BF/flat/64.png",
        "Burundi" to "https://flagsapi.com/BI/flat/64.png",
        "Cambodia" to "https://flagsapi.com/KH/flat/64.png",
        "Cameroon" to "https://flagsapi.com/CM/flat/64.png",
        "Canada" to "https://flagsapi.com/CA/flat/64.png",
        "Cape Verde" to "https://flagsapi.com/CV/flat/64.png",
        "Central African Republic" to "https://flagsapi.com/CF/flat/64.png",
        "Chad" to "https://flagsapi.com/TD/flat/64.png",
        "Chile" to "https://flagsapi.com/CL/flat/64.png",
        "China" to "https://flagsapi.com/CN/flat/64.png",
        "Colombia" to "https://flagsapi.com/CO/flat/64.png",
        "Comoros" to "https://flagsapi.com/KM/flat/64.png",
        "Congo" to "https://flagsapi.com/CG/flat/64.png",
        "Costa Rica" to "https://flagsapi.com/CR/flat/64.png",
        "Croatia" to "https://flagsapi.com/HR/flat/64.png",
        "Cuba" to "https://flagsapi.com/CU/flat/64.png",
        "Cyprus" to "https://flagsapi.com/CY/flat/64.png",
        "Czech Republic" to "https://flagsapi.com/CZ/flat/64.png",
        "Denmark" to "https://flagsapi.com/DK/flat/64.png",
        "Djibouti" to "https://flagsapi.com/DJ/flat/64.png",
        "Dominica" to "https://flagsapi.com/DM/flat/64.png",
        "Dominican Republic" to "https://flagsapi.com/DO/flat/64.png",
        "Ecuador" to "https://flagsapi.com/EC/flat/64.png",
        "Egypt" to "https://flagsapi.com/EG/flat/64.png",
        "El Salvador" to "https://flagsapi.com/SV/flat/64.png",
        "Equatorial Guinea" to "https://flagsapi.com/GQ/flat/64.png",
        "Eritrea" to "https://flagsapi.com/ER/flat/64.png",
        "Estonia" to "https://flagsapi.com/EE/flat/64.png",
        "Ethiopia" to "https://flagsapi.com/ET/flat/64.png",
        "Fiji" to "https://flagsapi.com/FJ/flat/64.png",
        "Finland" to "https://flagsapi.com/FI/flat/64.png",
        "France" to "https://flagsapi.com/FR/flat/64.png",
        "Gabon" to "https://flagsapi.com/GA/flat/64.png",
        "Gambia" to "https://flagsapi.com/GM/flat/64.png",
        "Georgia" to "https://flagsapi.com/GE/flat/64.png",
        "Germany" to "https://flagsapi.com/DE/flat/64.png",
        "Ghana" to "https://flagsapi.com/GH/flat/64.png",
        "Greece" to "https://flagsapi.com/GR/flat/64.png",
        "Grenada" to "https://flagsapi.com/GD/flat/64.png",
        "Guatemala" to "https://flagsapi.com/GT/flat/64.png",
        "Guinea" to "https://flagsapi.com/GN/flat/64.png",
        "Guinea-Bissau" to "https://flagsapi.com/GW/flat/64.png",
        "Guyana" to "https://flagsapi.com/GY/flat/64.png",
        "Haiti" to "https://flagsapi.com/HT/flat/64.png",
        "Honduras" to "https://flagsapi.com/HN/flat/64.png",
        "Hungary" to "https://flagsapi.com/HU/flat/64.png",
        "Iceland" to "https://flagsapi.com/IS/flat/64.png",
        "India" to "https://flagsapi.com/IN/flat/64.png",
        "Indonesia" to "https://flagsapi.com/ID/flat/64.png",
        "Iran" to "https://flagsapi.com/IR/flat/64.png",
        "Iraq" to "https://flagsapi.com/IQ/flat/64.png",
        "Ireland" to "https://flagsapi.com/IE/flat/64.png",
        "Israel" to "https://flagsapi.com/IL/flat/64.png",
        "Italy" to "https://flagsapi.com/IT/flat/64.png",
        "Jamaica" to "https://flagsapi.com/JM/flat/64.png",
        "Japan" to "https://flagsapi.com/JP/flat/64.png",
        "Jordan" to "https://flagsapi.com/JO/flat/64.png",
        "Kazakhstan" to "https://flagsapi.com/KZ/flat/64.png",
        "Kenya" to "https://flagsapi.com/KE/flat/64.png",
        "Kiribati" to "https://flagsapi.com/KI/flat/64.png",
        "North Korea" to "https://flagsapi.com/KP/flat/64.png",
        "South Korea" to "https://flagsapi.com/KR/flat/64.png",
        "Kuwait" to "https://flagsapi.com/KW/flat/64.png",
        "Kyrgyzstan" to "https://flagsapi.com/KG/flat/64.png",
        "Laos" to "https://flagsapi.com/LA/flat/64.png",
        "Latvia" to "https://flagsapi.com/LV/flat/64.png",
        "Lebanon" to "https://flagsapi.com/LB/flat/64.png",
        "Lesotho" to "https://flagsapi.com/LS/flat/64.png",
        "Liberia" to "https://flagsapi.com/LR/flat/64.png",
        "Libya" to "https://flagsapi.com/LY/flat/64.png",
        "Liechtenstein" to "https://flagsapi.com/LI/flat/64.png",
        "Lithuania" to "https://flagsapi.com/LT/flat/64.png",
        "Luxembourg" to "https://flagsapi.com/LU/flat/64.png",
        "Madagascar" to "https://flagsapi.com/MG/flat/64.png",
        "Malawi" to "https://flagsapi.com/MW/flat/64.png",
        "Malaysia" to "https://flagsapi.com/MY/flat/64.png",
        "Maldives" to "https://flagsapi.com/MV/flat/64.png",
        "Mali" to "https://flagsapi.com/ML/flat/64.png",
        "Malta" to "https://flagsapi.com/MT/flat/64.png",
        "Marshall Islands" to "https://flagsapi.com/MH/flat/64.png",
        "Mauritania" to "https://flagsapi.com/MR/flat/64.png",
        "Mauritius" to "https://flagsapi.com/MU/flat/64.png",
        "Mexico" to "https://flagsapi.com/MX/flat/64.png",
        "Micronesia" to "https://flagsapi.com/FM/flat/64.png",
        "Moldova" to "https://flagsapi.com/MD/flat/64.png",
        "Monaco" to "https://flagsapi.com/MC/flat/64.png",
        "Mongolia" to "https://flagsapi.com/MN/flat/64.png",
        "Montenegro" to "https://flagsapi.com/ME/flat/64.png",
        "Morocco" to "https://flagsapi.com/MA/flat/64.png",
        "Mozambique" to "https://flagsapi.com/MZ/flat/64.png",
        "Myanmar" to "https://flagsapi.com/MM/flat/64.png",
        "Namibia" to "https://flagsapi.com/NA/flat/64.png",
        "Nauru" to "https://flagsapi.com/NR/flat/64.png",
        "Nepal" to "https://flagsapi.com/NP/flat/64.png",
        "Netherlands" to "https://flagsapi.com/NL/flat/64.png",
        "New Zealand" to "https://flagsapi.com/NZ/flat/64.png",
        "Nicaragua" to "https://flagsapi.com/NI/flat/64.png",
        "Niger" to "https://flagsapi.com/NE/flat/64.png",
        "Nigeria" to "https://flagsapi.com/NG/flat/64.png",
        "North Macedonia" to "https://flagsapi.com/MK/flat/64.png",
        "Norway" to "https://flagsapi.com/NO/flat/64.png",
        "Oman" to "https://flagsapi.com/OM/flat/64.png",
        "Pakistan" to "https://flagsapi.com/PK/flat/64.png",
        "Palau" to "https://flagsapi.com/PW/flat/64.png",
        "Panama" to "https://flagsapi.com/PA/flat/64.png",
        "Papua New Guinea" to "https://flagsapi.com/PG/flat/64.png",
        "Paraguay" to "https://flagsapi.com/PY/flat/64.png",
        "Peru" to "https://flagsapi.com/PE/flat/64.png",
        "Philippines" to "https://flagsapi.com/PH/flat/64.png",
        "Poland" to "https://flagsapi.com/PL/flat/64.png",
        "Portugal" to "https://flagsapi.com/PT/flat/64.png",
        "Qatar" to "https://flagsapi.com/QA/flat/64.png",
        "Romania" to "https://flagsapi.com/RO/flat/64.png",
        "Russia" to "https://flagsapi.com/RU/flat/64.png",
        "Rwanda" to "https://flagsapi.com/RW/flat/64.png",
        "Saint Kitts and Nevis" to "https://flagsapi.com/KN/flat/64.png",
        "Saint Lucia" to "https://flagsapi.com/LC/flat/64.png",
        "Saint Vincent and the Grenadines" to "https://flagsapi.com/VC/flat/64.png",
        "Samoa" to "https://flagsapi.com/WS/flat/64.png",
        "San Marino" to "https://flagsapi.com/SM/flat/64.png",
        "São Tomé and Príncipe" to "https://flagsapi.com/ST/flat/64.png",
        "Saudi Arabia" to "https://flagsapi.com/SA/flat/64.png",
        "Senegal" to "https://flagsapi.com/SN/flat/64.png",
        "Serbia" to "https://flagsapi.com/RS/flat/64.png",
        "Seychelles" to "https://flagsapi.com/SC/flat/64.png",
        "Sierra Leone" to "https://flagsapi.com/SL/flat/64.png",
        "Singapore" to "https://flagsapi.com/SG/flat/64.png",
        "Slovakia" to "https://flagsapi.com/SK/flat/64.png",
        "Slovenia" to "https://flagsapi.com/SI/flat/64.png",
        "Solomon Islands" to "https://flagsapi.com/SB/flat/64.png",
        "Somalia" to "https://flagsapi.com/SO/flat/64.png",
        "South Africa" to "https://flagsapi.com/ZA/flat/64.png",
        "South Sudan" to "https://flagsapi.com/SS/flat/64.png",
        "Spain" to "https://flagsapi.com/ES/flat/64.png",
        "Sri Lanka" to "https://flagsapi.com/LK/flat/64.png",
        "Sudan" to "https://flagsapi.com/SD/flat/64.png",
        "Suriname" to "https://flagsapi.com/SR/flat/64.png",
        "Eswatini" to "https://flagsapi.com/SZ/flat/64.png",
        "Sweden" to "https://flagsapi.com/SE/flat/64.png",
        "Switzerland" to "https://flagsapi.com/CH/flat/64.png",
        "Syria" to "https://flagsapi.com/SY/flat/64.png",
        "Tajikistan" to "https://flagsapi.com/TJ/flat/64.png",
        "Tanzania" to "https://flagsapi.com/TZ/flat/64.png",
        "Thailand" to "https://flagsapi.com/TH/flat/64.png",
        "Timor-Leste" to "https://flagsapi.com/TL/flat/64.png",
        "Togo" to "https://flagsapi.com/TG/flat/64.png",
        "Tonga" to "https://flagsapi.com/TO/flat/64.png",
        "Trinidad and Tobago" to "https://flagsapi.com/TT/flat/64.png",
        "Tunisia" to "https://flagsapi.com/TN/flat/64.png",
        "Turkey" to "https://flagsapi.com/TR/flat/64.png",
        "Turkmenistan" to "https://flagsapi.com/TM/flat/64.png",
        "Tuvalu" to "https://flagsapi.com-TV/flat/64.png",
        "Uganda" to "https://flagsapi.com/UG/flat/64.png",
        "Ukraine" to "https://flagsapi.com/UA/flat/64.png",
        "United Arab Emirates" to "https://flagsapi.com/AE/flat/64.png",
        "United Kingdom" to "https://flagsapi.com/GB/flat/64.png",
        "United States" to "https://flagsapi.com/US/flat/64.png",
        "Uruguay" to "https://flagsapi.com/UY/flat/64.png",
        "Uzbekistan" to "https://flagsapi.com/UZ/flat/64.png",
        "Vanuatu" to "https://flagsapi.com/VU/flat/64.png",
        "Vatican City" to "https://flagsapi.com/VA/flat/64.png",
        "Venezuela" to "https://flagsapi.com/VE/flat/64.png",
        "Vietnam" to "https://flagsapi.com/VN/flat/64.png",
        "Yemen" to "https://flagsapi.com/YE/flat/64.png",
        "Zambia" to "https://flagsapi.com/ZM/flat/64.png",
        "Zimbabwe" to "https://flagsapi.com/ZW/flat/64.png"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryPicker(modifier: Modifier = Modifier, onClick: (String) -> Unit) {
    var countryName by rememberSaveable { mutableStateOf("") }
    var selectedCountry by rememberSaveable { mutableStateOf<Int?>(null) }
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var state = rememberModalBottomSheetState()

    Text(
        text = "Country",
        style = bodyRegular16,
        color = GrayG700,
        modifier = modifier.padding(vertical = 8.dp)
    )

    OutlinedTextField(
        value = countryName,
        onValueChange = { countryName = it },
        enabled = false,
        readOnly = true,
        colors = OutlinedTextFieldDefaults.colors(
            disabledTrailingIconColor = GrayG100,
            disabledContainerColor = GrayG10,
            disabledBorderColor = GrayG70,
            disabledPlaceholderColor = GrayG70,
        ),
        placeholder = { Text(text = "Select your country", color = GrayG70) },
        trailingIcon = {
            IconButton(onClick = { isBottomSheetVisible = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_dropdown),
                    contentDescription = "select a country ",
                    modifier = modifier.size(24.dp)
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .clickable {
                isBottomSheetVisible = true
            }
    )

    if (isBottomSheetVisible) {
        ModalBottomSheet(
            sheetState = state,
            content = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(Countries.nameWithFlags) { (country, flagUrl) ->
                        CountryItem(
                            country = country,
                            isSelected = selectedCountry == Countries.nameWithFlags.indexOf(Pair(country, flagUrl)),
                            imageUrl = flagUrl,
                            onSelect = {
                                selectedCountry = Countries.nameWithFlags.indexOf(Pair(country, flagUrl))
                                isBottomSheetVisible = false
                            }
                        ) {
                            onClick(it)
                            countryName = it
                        }
                    }
                }
            },
            onDismissRequest = { isBottomSheetVisible = false },
            containerColor = Color.White
        )
    }
}


@Composable
fun CountryItem(
    country: String,
    isSelected: Boolean,
    imageUrl: String,
    onSelect: () -> Unit,
    onCardClick: (String) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(if (isSelected) RedP50 else Color.Transparent)
            .clickable {
                onCardClick(country)
                onSelect()
            },
    ) {
        Spacer(modifier = Modifier.padding(start = 8.dp))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .build(),
            contentDescription = "Country Image",
            placeholder = painterResource(R.drawable.ic_flag),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .clip(CircleShape)
                .size(35.dp),
        )
        Text(
            text = country,
            style = bodyMedium16,
            color = Color(0xFF706E6C),
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        if (isSelected) {
            Icon(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "Selected Country",
                tint = RedP300,
                modifier = Modifier.padding(end = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun prevv() {
    CountryItem(country = "Egypt", isSelected = false, imageUrl ="" , onSelect = { /*TODO*/ }) {

    }
}