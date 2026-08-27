package com.example.nflteams

/**
 * Simple data model for an NFL team.
 *
 * [color] is the team's official primary color, used to render a generated
 * badge thumbnail (colored circle + abbreviation) when no real logo image
 * is supplied.
 *
 * [logoRes] is an OPTIONAL drawable resource name (no extension, e.g.
 * "logo_buf") for a real logo image dropped into res/drawable. If set and
 * the resource exists, the adapter shows that image instead of the
 * generated badge.
 *
 * [espnAbbr] is the team code ESPN uses in its depth-chart URLs. It's
 * usually just the lowercase [abbr], EXCEPT Washington, where ESPN uses
 * "wsh" instead of "was" — so this field lets us override that one case.
 */
data class Team(
    val name: String,
    val abbr: String,
    val conference: String, // "AFC" or "NFC"
    val color: String,       // hex color, e.g. "#013369"
    val logoRes: String? = null,
    val espnAbbr: String? = null
) {
    /** ESPN depth chart URL for this team, e.g. .../name/buf */
    val depthChartUrl: String
        get() = "https://www.espn.com/nfl/team/depth/_/name/${espnAbbr ?: abbr.lowercase()}"
}

object TeamRepository {

    val teams: List<Team> = listOf(
        // AFC East
        Team("Buffalo Bills", "BUF", "AFC", "#00338D", logoRes = "logo_buf"),
        Team("Miami Dolphins", "MIA", "AFC", "#008E97", logoRes = "logo_mia"),
        Team("New England Patriots", "NE", "AFC", "#002244", logoRes = "logo_ne"),
        Team("New York Jets", "NYJ", "AFC", "#125740", logoRes = "logo_nyj"),

        // AFC North
        Team("Baltimore Ravens", "BAL", "AFC", "#241773", logoRes = "logo_bal"),
        Team("Cincinnati Bengals", "CIN", "AFC", "#FB4F14", logoRes = "logo_cin"),
        Team("Cleveland Browns", "CLE", "AFC", "#311D00", logoRes = "logo_cle"),
        Team("Pittsburgh Steelers", "PIT", "AFC", "#FFB612", logoRes = "logo_pit"),

        // AFC South
        Team("Houston Texans", "HOU", "AFC", "#03202F", logoRes = "logo_hou"),
        Team("Indianapolis Colts", "IND", "AFC", "#002C5F", logoRes = "logo_ind"),
        Team("Jacksonville Jaguars", "JAX", "AFC", "#101820", logoRes = "logo_jax"),
        Team("Tennessee Titans", "TEN", "AFC", "#0C2340", logoRes = "logo_ten"),

        // AFC West
        Team("Denver Broncos", "DEN", "AFC", "#FB4F14", logoRes = "logo_den"),
        Team("Kansas City Chiefs", "KC", "AFC", "#E31837", logoRes = "logo_kc"),
        Team("Las Vegas Raiders", "LV", "AFC", "#000000", logoRes = "logo_lvr"),
        Team("Los Angeles Chargers", "LAC", "AFC", "#0080C6", logoRes = "logo_lac"),

        // NFC East
        Team("Dallas Cowboys", "DAL", "NFC", "#003594", logoRes = "logo_dal"),
        Team("New York Giants", "NYG", "NFC", "#0B2265", logoRes = "logo_nyg"),
        Team("Philadelphia Eagles", "PHI", "NFC", "#004C54", logoRes = "logo_phi"),
        Team("Washington Commanders", "WAS", "NFC", "#5A1414", espnAbbr = "wsh", logoRes = "logo_was"),

        // NFC North
        Team("Chicago Bears", "CHI", "NFC", "#0B162A", logoRes = "logo_chi"),
        Team("Detroit Lions", "DET", "NFC", "#0076B6", logoRes = "logo_det"),
        Team("Green Bay Packers", "GB", "NFC", "#203731", logoRes = "logo_gb"),
        Team("Minnesota Vikings", "MIN", "NFC", "#4F2683", logoRes = "logo_min"),

        // NFC South
        Team("Atlanta Falcons", "ATL", "NFC", "#A71930", logoRes = "logo_atl"),
        Team("Carolina Panthers", "CAR", "NFC", "#0085CA", logoRes = "logo_car"),
        Team("New Orleans Saints", "NO", "NFC", "#D3BC8D", logoRes = "logo_no"),
        Team("Tampa Bay Buccaneers", "TB", "NFC", "#D50A0A", logoRes = "logo_tb"),

        // NFC West
        Team("Arizona Cardinals", "ARI", "NFC", "#97233F", logoRes = "logo_ari"),
        Team("Los Angeles Rams", "LAR", "NFC", "#003594", logoRes = "logo_lar"),
        Team("San Francisco 49ers", "SF", "NFC", "#AA0000", logoRes = "logo_sf"),
        Team("Seattle Seahawks", "SEA", "NFC", "#002244", logoRes = "logo_sea")
    )
}